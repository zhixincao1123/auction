package cn.web.auction.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.web.auction.mapper.AuctionCustomMapper;
import cn.web.auction.mapper.AuctionMapper;
import cn.web.auction.pojo.Auction;
import cn.web.auction.pojo.AuctionExample;
import cn.web.auction.service.AuctionService;

@Service
public class AuctionServiceImpl implements AuctionService {
@Autowired
AuctionMapper auctionMapper;

@Autowired
AuctionCustomMapper auctionCustomMapper;
@Override
public List<Auction>findAuctions(Auction condition){
	AuctionExample example=new AuctionExample();
	//对于条件的指定，我们用那个critiria
	AuctionExample.Criteria criteria=example.createCriteria();
	//对每一项 进行探访
	//名称
	if (condition.getAuctionname()!=null && !condition.getAuctionname().equals("")) {
		//字符串非空判断 上
		criteria.andAuctionnameLike("%"+condition.getAuctionname()+"%");//对于名称或字符串类的话做的是模糊查询，而模糊查询 用 like
	//接下来对词进行拼接，即修改value 
		
	}
	
	//描述
	if (condition.getAuctiondesc()!=null && !condition.getAuctiondesc().equals("")) {
		criteria.andAuctiondescLike("%"+condition.getAuctiondesc()+"%");//反复确认 criteria 确认 再往下写
	}
	
	//开始结束时间不用模糊查询
	//利用 范围区间：用户输入内容与商品原有内容的区间 来做比较 时间先后的比较
	//画一个商品固有的范围时间， 商品的时间区间一定要在用户所定义的时间区间以内，此时就有了相应判断的条件。
	//用户指定的条件 一定要早于商品固有的拍卖时间
	//select* from auction where auctionStartTime>""
	if (condition.getAuctionstarttime()!=null) {
		criteria.andAuctionstarttimeGreaterThan(condition.getAuctionstarttime());
	}
	//结束时间
	if (condition.getAuctionendtime()!=null) {
		criteria.andAuctionendtimeLessThan(condition.getAuctionendtime());
	}
	
	//起拍价 价格区间
	//devimal可以直接运算 decimal 值不可以用于比较 ，如果要比较，必须把decimal改成double
	example.setOrderByClause("auctionstarttime desc");
	return auctionMapper.selectByExample(example);}
@Override
public Auction findAuctionAndRecordListById(int auctionid) {
	// TODO Auto-generated method stub
	return auctionCustomMapper.findAuctionAndRecordListById(auctionid);
}
}
