import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root',
})

export class BankDetailsService {
  constructor(private http: HttpClient) { }

  getAccountDetails() {
    //access httpClient
    //To do so import the httpClient in app.module.ts;
    return this.http.get("http://localhost:8080/api/lets-transact/allAccountDetails")
  }

  getDetails() {
    return this.http.get("http://localhost:8080/getDetails")
  }

  updateBalance(customer_id: any, balance: any) {
    const updateUrl = "http://localhost:8080/api/lets-transact/updateAccDetails/" + customer_id;

    return this.http.put(updateUrl, balance);
  }

  postData(txn: any){
    const updateUrl = "http://localhost:8080/api/lets-transact/transactions/save";

    return this.http.post(updateUrl, txn);
  }

  getTxnData(){
    const getUrl = "http://localhost:8080/api/lets-transact/transactions/";
    return this.http.get(getUrl);

  }
}
