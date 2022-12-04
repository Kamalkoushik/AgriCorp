package com.jfsd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsd.model.Tips;
import com.jfsd.repository.TipsRepo;

@Service
public class TipsServiceImpl implements TipsService
{
	@Autowired
	private TipsRepo tipsrepo;

	@Override
	public Tips addTips(Tips tips) {
		return tipsrepo.save(tips);
	}
}
