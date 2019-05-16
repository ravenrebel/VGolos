import { Component, OnInit } from '@angular/core';
import { AccountService } from 'src/app/service/account.service';
import { CustomeAuthService } from 'src/app/service/custome-auth.service';
import { Account } from 'src/app/model/account';

@Component({
  selector: 'app-accounts',
  templateUrl: './accounts.component.html',
  styleUrls: ['./accounts.component.css']
})
export class AccountsComponent implements OnInit {

  accounts: Account[];
  currAccount: Account;

  constructor(private accountService: AccountService,
    private authService: CustomeAuthService) { }

  ngOnInit() {
    this.accountService.findAll().subscribe(data => {
      this.accounts = data;
    });
    this.authService.getCurrentUser().subscribe(account => {
      this.currAccount = account;
    });
  }

  delete(id: number) {
    console.log(id);
    this.accounts = this.accounts.filter(account => +account.id != id);
    this.accountService.delete(id).subscribe(data => {});
  }

}
