import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BankDetailsComponent } from './bank-details/bank-details.component';
import { TransactionComponent } from './transaction/transaction.component'; 

const routes: Routes = [
  {path: '', component: BankDetailsComponent},
  // {path: 'bankDetails', component: BankDetailsComponent},
  {path: 'transactionTable', component: TransactionComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
