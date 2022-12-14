package cn.web.auction.service;

import java.util.List;

import cn.web.auction.pojo.Auction;

public interface AuctionService {
//首页商品列表显示
	public List<Auction>findAuctions(Auction condition);
	//竞拍商品详情
	public Auction findAuctionAndRecordListById(int auctionid);
}
