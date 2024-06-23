package com.AcordApi.Application.Quote.Command.QuoteCommandHandler;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.AcordApi.Application.Common.Interface.IQuoteDataAccess;
import com.AcordApi.Application.Quote.Query.GetQuote.GetQuoteQuery;
import com.AcordApi.Application.Quote.Query.GetQuote.QuoteDTO;
import com.AcordApi.Application.Quote.Query.GetQuote.QuoteVm;
import com.AcordApi.Mediator.RequestHandler;

@Component
public class QuoteQueryHandler implements RequestHandler<GetQuoteQuery, QuoteVm>{
	
	private final ModelMapper mapper = new ModelMapper();
	@Autowired
	private IQuoteDataAccess _dataAccess;

	@Override
	public QuoteVm handle(GetQuoteQuery request) {
//		RetrievePolicyVm retrievePolicyVm = new RetrievePolicyVm();
//		retrievePolicyVm.setLists(mapper.map(_dataAccess.GetList(), new TypeToken<List<RetrievePolicyDTO>>() {
//		}.getType()));
		QuoteVm quoteVm = new QuoteVm();
		quoteVm.setLists(mapper.map(_dataAccess.GetList(), new TypeToken<List<QuoteDTO>>() {}.getType()));
		return quoteVm;
	}

	@Override
	public UUID uhandle(GetQuoteQuery request) {
		// TODO Auto-generated method stub
		return null;
	}

}
