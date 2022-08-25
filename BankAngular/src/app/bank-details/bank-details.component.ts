import { Component, OnInit, ɵɵqueryRefresh } from '@angular/core';
import { BankDetailsService } from '../bank-details.service';
import { BankDetails } from '../bank-details'
import { Router } from '@angular/router';


@Component({
  selector: 'app-bank-details',
  templateUrl: './bank-details.component.html',
  styleUrls: ['./bank-details.component.css']
})
export class BankDetailsComponent implements OnInit {
  bankdetails: any;
  exdetails: any;
  fileName: string = '';


  constructor(private service: BankDetailsService, private router: Router) { }

  ngOnInit(): void {

    const d = new Date();
    const day = d.getDay();

    if(day == 6  || day == 6){
      while(true){
        alert("Today is Saturday & Sundady, Non Working Days!");
      }
    }
    else{
      /**
       * Getting the data Objects from the Customer Data Table
      **/
      this.service.getAccountDetails().subscribe(data => {
        this.bankdetails = data;
      });

      /**
       * Getting The data Objects from the Bank Details Table
      **/
      this.service.getDetails().subscribe(exdata => {
        this.exdetails = exdata;
      });

      /**
       * Getting The data Objects fot transaction data
       * 
      **/
  }


  }



  /**
   * Sender Details To Autofill the Values in the input fields
   **/
  senderobj: any;                                                   //based on AccountNumber of sender
  getSenderDetails(val: string) {
    this.bankdetails.forEach((element: { customer_id: string; }) => {
      if (element.customer_id.toString() === val) {
        this.senderobj = element;
      }
    });
  }

  refreshData(){
    // this.senderobj = {}; 
    // this.reciverobj = {};
    window.location.reload()

  }

  /** 
   * Reciver Details To Autofill the Values in the input fields
  **/
  reciverobj: any;
  getReciverDetails(val: string) {                                  //based on AccountNumber of reciver
    this.bankdetails.forEach((ele: { customer_id: string; }) => {
      if (ele.customer_id.toString() === val) {
        this.reciverobj = ele;
      }
    });
  }


  /**
   * Getting the data of the Institution Code
  **/
  dataobj: any;
  dataBicVal: any;

  getDetails(bicVal: string) {                    //based on the BIC no.
    this.exdetails.forEach((element: { bic: string; }) => {
      if (element.bic.toString() === bicVal) {
        this.dataobj = element;
      }
    });
    this.dataBicVal = bicVal;
  }


  /**
   * Getting the Message Type
  **/
  selectedTeam: any;
  onSelected(value: string): void {
    this.selectedTeam = value;
  }


  txnType: any;
  txn(value: string) {
    this.txnType = value;
  }

  result: any;

  /**
   * POST Transaction Details to the Database
  **/
  transact() {
    const money = document.getElementById('money') as HTMLInputElement;
    const sbalance = document.getElementById('balance') as HTMLInputElement;
    const rbalance = (Number)(this.reciverobj.clear_balance_inr_credit);
    const recName = document.getElementById('accHoldNameRec') as HTMLInputElement;
    const senName = document.getElementById('accHoldNameSen') as HTMLInputElement;
    const overdraft = document.getElementById('overdraft') as HTMLInputElement;
    const bicno = document.getElementById("val") as HTMLInputElement;
    const recAccNo = (Number)(this.reciverobj.customer_id);
    const senAccNo = (Number)(this.senderobj.customer_id);
    const msgType = this.selectedTeam

    const interest = (Number)(money.value) * 0.25;
    const sval = (Number)(sbalance.value) - ((Number)(money.value) + interest);
    const rval = (Number)(rbalance) + (Number)(money.value);


    if (this.txnType === "BankTxn") {
      if (recName.value.startsWith("HDFC") && senName.value.startsWith("HDFC") && (recAccNo != senAccNo)) {
        if (overdraft.value.toString().toLowerCase() === "yes" &&
          (((Number)(money.value) >= (Number)(sbalance.value)) || ((Number)(money.value) < (Number)(sbalance.value)))){
            this.result = "Successfull";
          }
        if(overdraft.value.toString().toLowerCase() === "no" &&
        (!((Number)(money.value) > (Number)(sbalance.value)) || ((Number)(sbalance.value) >= (Number)(money.value)))){
          this.result = "Successfull";
        }
      }else{this.result = "Denied"}
    }

    else if(this.txnType === "CustomerTxn"){
      if (!(recName.value.startsWith("HDFC") && senName.value.startsWith("HDFC")) && (recAccNo != senAccNo)) {
        if (overdraft.value.toString().toLowerCase() === "yes" &&
          (((Number)(money.value) >= (Number)(sbalance.value)) || ((Number)(money.value) < (Number)(sbalance.value)))){
            this.result = "Successfull";
          }
        if(overdraft.value.toString().toLowerCase() === "no" &&
        (!((Number)(money.value) > (Number)(sbalance.value)) || ((Number)(sbalance.value) >= (Number)(money.value)))){
          this.result = "Successfull";
        }else{this.result = "Denied"}
      }else{this.result = "Denied"}
    }

    //Deducting the balance of the sender
    const arr1 = {
      clear_balance_inr_credit: sval,
    };

    //Updating the balance of the reciver
    const arr2 = {
      clear_balance_inr_credit: rval,
    };

    //Sender balance Updation
    this.service.updateBalance(senAccNo, arr1).subscribe((data) => {
      console.log(sval)
    });

    //Reciver balance Updation
    this.service.updateBalance(recAccNo, arr2).subscribe((data) => {
      console.log(rval)
    });
    
    const txnData = {
      "msgType": msgType,
      "receiverAccno": (Number)(recAccNo),
      "receiverName": recName.value,
      "result": this.result,
      "senderAccno": (Number)(senAccNo),
      "senderName": senName.value,
      "transferAmt": (Number)(money.value),
      "txnType": this.txnType,
    }

    this.service.postData(txnData).subscribe(data =>{
      console.log("Txn Data Posted Successfully");
      
    });
    this.refreshData();
  }

  transactionTable(){
    this.router.navigate(['transactionTable']);
  }
}






