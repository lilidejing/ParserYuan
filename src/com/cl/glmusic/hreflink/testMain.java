package com.cl.glmusic.hreflink;

import java.util.List;

//import org.hibernate.criterion.DetachedCriteria;
//import org.hibernate.criterion.Restrictions;
//
//import com.cl.glmusic.dao.IHrefLinkDao;
import com.cl.glmusic.entity.HrefLink;
import com.cl.glmusic.hreflink.HtmlParser;

public class testMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 String apple = "http://www.soku.com/search_video/q_%E5%B0%8F%E8%8B%B9%E6%9E%9C%E5%B9%BF%E5%9C%BA%E8%88%9E_orderby_1_limitdate_0?site=14&page=";
//		 String total = "http://www.soku.com/search_video/q_%E5%B9%BF%E5%9C%BA%E8%88%9E%E5%A4%A7%E5%85%A8_orderby_1_limitdate_0?site=14&page=";
//		 String fashion = "http://www.soku.com/search_video/q_%E6%9C%80%E7%82%AB%E5%B9%BF%E5%9C%BA%E8%88%9E_orderby_1_limitdate_0?site=14&page=";
         String guigu="http://www.soku.com/search_video/q_%E7%A1%85%E8%B0%B7%E4%BC%A0%E5%A5%87?f=1&kb=020200000000000_%E5%B0%8F%E8%8B%B9%E6%9E%9C%E5%B9%BF%E5%9C%BA%E8%88%9E_%E7%A1%85%E8%B0%B7&_rp=1471054932630pmR";
		 
		 for(int i=2;i<3;i++){
			 saveLink(guigu+i,1);
		 }
	}
	
	public static void saveLink(String url,int type) {
		HtmlParser hParser = new HtmlParser();
		List<HrefLink> hrefList = hParser.setHrefLink(url,type);
		HrefLink hrefLink = null;

		for (int i = 0; i < hrefList.size(); i++) {
			hrefLink = hrefList.get(i);

				System.out.println(hrefLink.getHrefLink());
		}
	}

}
