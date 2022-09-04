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
	//����������ָ�����������Ǹ�critiria
	AuctionExample.Criteria criteria=example.createCriteria();
	//��ÿһ�� ����̽��
	//����
	if (condition.getAuctionname()!=null && !condition.getAuctionname().equals("")) {
		//�ַ����ǿ��ж� ��
		criteria.andAuctionnameLike("%"+condition.getAuctionname()+"%");//�������ƻ��ַ�����Ļ�������ģ����ѯ����ģ����ѯ �� like
	//�������Դʽ���ƴ�ӣ����޸�value 
		
	}
	
	//����
	if (condition.getAuctiondesc()!=null && !condition.getAuctiondesc().equals("")) {
		criteria.andAuctiondescLike("%"+condition.getAuctiondesc()+"%");//����ȷ�� criteria ȷ�� ������д
	}
	
	//��ʼ����ʱ�䲻��ģ����ѯ
	//���� ��Χ���䣺�û�������������Ʒԭ�����ݵ����� �����Ƚ� ʱ���Ⱥ�ıȽ�
	//��һ����Ʒ���еķ�Χʱ�䣬 ��Ʒ��ʱ������һ��Ҫ���û��������ʱ���������ڣ���ʱ��������Ӧ�жϵ�������
	//�û�ָ�������� һ��Ҫ������Ʒ���е�����ʱ��
	//select* from auction where auctionStartTime>""
	if (condition.getAuctionstarttime()!=null) {
		criteria.andAuctionstarttimeGreaterThan(condition.getAuctionstarttime());
	}
	//����ʱ��
	if (condition.getAuctionendtime()!=null) {
		criteria.andAuctionendtimeLessThan(condition.getAuctionendtime());
	}
	
	//���ļ� �۸�����
	//devimal����ֱ������ decimal ֵ���������ڱȽ� �����Ҫ�Ƚϣ������decimal�ĳ�double
	example.setOrderByClause("auctionstarttime desc");
	return auctionMapper.selectByExample(example);}
@Override
public Auction findAuctionAndRecordListById(int auctionid) {
	// TODO Auto-generated method stub
	return auctionCustomMapper.findAuctionAndRecordListById(auctionid);
}
}
