import { Component, OnInit } from '@angular/core';
import { BankDetailsService } from '../bank-details.service';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {

  tables : any;
  constructor(private service: BankDetailsService) { }

  ngOnInit(): void {
    this.service.getTxnData().subscribe(txndata => {
      this.tables = txndata;
    });
  }

}
