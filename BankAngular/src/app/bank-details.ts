export class BankDetails {
	constructor(
	public customer_id: number,
	public account_holder_name: string,
	public clear_balance_inr_credit: number,
	public transfer_type: string,
	public overdraft: string,

	public bic : string,
    public rec_institution_name: string,
	){

	}

    
    
}
