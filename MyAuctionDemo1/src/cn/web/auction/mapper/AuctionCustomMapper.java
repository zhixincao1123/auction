package cn.web.auction.mapper;

import cn.web.auction.pojo.Auction;

public interface AuctionCustomMapper {
//��ʾҳ��Ľӿڷ���
	public  Auction findAuctionAndRecordListById(int auctionid);
}