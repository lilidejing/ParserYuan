package com.cl.glmusic.hreflink;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;

import com.cl.glmusic.entity.HrefLink;

public class HtmlParser {

	private List<HrefLink> hrefLinkList = new ArrayList<HrefLink>();

	/**
	 * 存放结果数据
	 */
	private ArrayList<String> imgList = new ArrayList<String>();
	private ArrayList<String> timeList = new ArrayList<String>();
	private ArrayList<String> linkList = new ArrayList<String>();
	private ArrayList<String> linkStream = new ArrayList<String>();
	private ArrayList<Map<String, String>> hrefList = new ArrayList<Map<String, String>>();

	/**
	 * 解析网页，使用正则匹�?
	 * 
	 * @param htmlUrl
	 * @throws IOException
	 */
	private void parser(String htmlUrl) throws IOException {
		URL url = new URL(htmlUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);

		InputStreamReader isr = new InputStreamReader(connection.getInputStream(), "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		String str = null, rs1 = null, rs2 = null, rs3 = null;
		ArrayList<String> li = new ArrayList<String>();
		while ((str = br.readLine()) != null) {
			MatcherHref mh = new MatcherHref();

			rs1 = mh.getHrefImg(str);
			rs2 = mh.getHrefTime(str);
			rs3 = mh.getHrefLink(str);
			if (rs1 != null) {
				imgList.add(rs1);
			}
			if (rs2 != null) {
				timeList.add(rs2);
			}
			if (rs3 != null) {
				linkList.add(rs3);
				li.add(rs3);
				if (li.size() == 20) {
					break;
				}
			}
		}
		br.close();
		isr.close();
	}

	private boolean parserStream(String htmlUrl) throws IOException {
		boolean b = false;
		URL url = new URL(htmlUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);

		InputStreamReader isr = new InputStreamReader(connection.getInputStream(), "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		String str = null, rs = null;

		while ((str = br.readLine()) != null) {
			//正则表达式进行匹�?
			MatcherHref mh = new MatcherHref();
			rs = mh.getHrefStream(str);

			if (rs != null) {
				linkStream.add(rs);
				b = true;
				break;
			}
		}
		br.close();
		isr.close();
		return b;
	}

	public List<HrefLink> setHrefLink(String url, int type) {

		String[] img = null, link = null, stream = null;

		try {
			parser(url);

			for (int i = 0; i < linkList.size(); i++) {
				for (int j = linkList.size() - 1; j > i; j--) {
					if (linkList.get(i).equals(linkList.get(j))) {
						linkList.remove(j);
					}
				}
			}

			List<Integer> re = new ArrayList<Integer>();
			for (int i = 0; i < linkList.size(); i++) {

				link = linkList.get(i).split("\"");

				if (!parserStream(link[5])) {
					re.add(i);
				}

			}
			for (int a = 0; a < re.size(); a++) {
				int c = re.get(a);
				linkList.remove(c);
				timeList.remove(c);
				imgList.remove(c);
			}

			for (int i = 0; i < linkList.size(); i++) {

				HrefLink hrefLink = new HrefLink();
				img = imgList.get(i).split("\"");
				stream = linkStream.get(i).split("\"");
				link = linkList.get(i).split("\"");
				hrefLink.setHrefImg(img[1]);
				hrefLink.setHrefTime(timeList.get(i).substring(15, 20));
				hrefLink.setHrefTitle(link[1]);
				hrefLink.setHrefLink(stream[1]);
				hrefLink.setType(type);

				hrefLinkList.add(hrefLink);
			}

			return hrefLinkList;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return hrefLinkList;

	}
	
	
	
public static void main(String[] args) {
	
	
	HtmlParser mHtmlParser=new HtmlParser();
	List<HrefLink> mLinklist;
	try {
		mLinklist=mHtmlParser.setHrefLink("http://www.soku.com/search_video/q_%E5%B0%8F%E8%8B%B9%E6%9E%9C%E5%B9%BF%E5%9C%BA%E8%88%9E_orderby_1_limitdate_0?site=14&page=2",1);
	    
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

}