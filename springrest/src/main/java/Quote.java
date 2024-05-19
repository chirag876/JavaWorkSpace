
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

@Entity
@Table(name = "QUOTE")
@TypeDefs({ @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class) })
public class Quote {
	
	// Defining the primary key field for the Entity
    @javax.persistence.Id
	@Column(name = "ID")
	private UUID Id = UUID.randomUUID();
    
	@Column(name = "QUOTE_ID")
	private UUID QuoteId = UUID.randomUUID();

    // Mapping the JSON data type using hibernate TypeDef
    @Type(type = "jsonb")
    @Column(name = "QUOTE_JSON", columnDefinition = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    private JsonNode QuoteJsonB;
    
    public Quote() {
    	
    }

	public Quote(UUID id, UUID quoteId, JsonNode quoteJsonB) {
		super();
		Id = id;
		QuoteId = quoteId;
		QuoteJsonB = quoteJsonB;
	}

	public UUID getId() {
		return Id;
	}

	public void setId(UUID id) {
		Id = id;
	}

	public UUID getQuoteId() {
		return QuoteId;
	}

	public void setQuoteId(UUID quoteId) {
		QuoteId = quoteId;
	}

	public JsonNode getQuoteJsonB() {
		return QuoteJsonB;
	}

	public void setQuoteJsonB(JsonNode quoteJsonB) {
		QuoteJsonB = quoteJsonB;
	}

	
	


}
