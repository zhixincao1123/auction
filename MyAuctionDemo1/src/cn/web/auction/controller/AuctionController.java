package cn.web.auction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.web.auction.pojo.Auction;
import cn.web.auction.service.AuctionService;

@Controller
@RequestMapping("/auction")
public class AuctionController {
	
@Autowired
AuctionService auctionService;

public static final int PAGE_SIZE=3;

@RequestMapping("/queryAuctions")
public ModelAndView queryAuctions(@RequestParam(defaultValue = "1",required = false,value ="pageNum" ) int pageNum,@ModelAttribute("condition")Auction condition) {
	
	ModelAndView mv=new ModelAndView();
	//pageNum:��ǰҳ�� pageSize:ÿҳ��ʾ����������
PageHelper.startPage(pageNum, PAGE_SIZE);
	List<Auction> auctionList = auctionService.findAuctions(condition);
	
	mv.addObject("auctionList", auctionList);
	PageInfo pageInfo=new PageInfo<>(auctionList);//���Ͳ���ָ�� <>��<>��
	
	mv.addObject("pageInfo", pageInfo);//ֵ�������pageInfo��Ӧ��
	//��mvָ��Ҫ��Ⱦ��ҳ��
	//mv.addObject("condition", condition);
	mv.setViewName("index");
	
	return mv;
	
}
//��������ҳ
@RequestMapping("/toDetail/{auctionid}")

public ModelAndView toDetail(@PathVariable int auctionid) {
	Auction auction = auctionService.findAuctionAndRecordListById(auctionid);
    ModelAndView mv=new ModelAndView();
    mv.addObject("auctionDetail", auction);//��װ���
    mv.setViewName("auctionDetail");
    return mv;
}
}