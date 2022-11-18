package entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntity {

	private int id;
	private String transactionNumber;
	private String walletNumber;
	private String room;
	private float grandTotal;
	private String dateCreated;
	private String status;
}
