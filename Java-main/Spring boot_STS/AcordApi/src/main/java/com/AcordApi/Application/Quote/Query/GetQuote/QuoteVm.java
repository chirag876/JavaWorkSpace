package com.AcordApi.Application.Quote.Query.GetQuote;

import java.util.List;

import com.AcordApi.Application.Quote.Query.GetQuote.QuoteDTO;

public class QuoteVm {
	
public List<QuoteDTO> lists;
	
	public QuoteVm() {}

	public List<QuoteDTO> getLists() {
		return lists;
	}

	public void setLists(List<QuoteDTO> lists) {
		this.lists = lists;
	}

}
