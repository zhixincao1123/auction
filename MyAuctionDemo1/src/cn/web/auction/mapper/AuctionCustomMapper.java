package cn.web.auction.mapper;

import cn.web.auction.pojo.Auction;

public interface AuctionCustomMapper {
//显示页面的接口方法
	public  Auction findAuctionAndRecordListById(int auctionid);
}
