package com.AcordApi.Application.Common.Interface;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.AcordApi.Application.Domain.Entity.Quote;

@Repository
@Transactional
public interface IQuoteDataAccess {
	
	public Quote AddQuote(Quote quote);

	public List<Quote> GetList();

	public Quote GetById(UUID id);

	public Quote Update(Quote quote);

	public UUID delete(UUID id);

}
