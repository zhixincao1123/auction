package cn.web.auction.service;

import java.util.List;

import cn.web.auction.pojo.Auction;

public interface AuctionService {
//��ҳ��Ʒ�б���ʾ
	public List<Auction>findAuctions(Auction condition);
	//������Ʒ����
	public Auction findAuctionAndRecordListById(int auctionid);
}