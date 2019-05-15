import { Component, OnInit } from '@angular/core';
import { AccountService } from 'src/app/service/account.service';

@Component({
  selector: 'app-accounts',
  templateUrl: './accounts.component.html',
  styleUrls: ['./accounts.component.css']
})
export class AccountsComponent implements OnInit {

  accounts: Account[];

  constructor(private accountService: AccountService) { }

  ngOnInit() {
    this.accountService.findAll().subscribe(data => {
      this.accounts = data;
    });
  }

  delete(id: number) {
    console.log(id);
    this.accounts = this.accounts.filter(account => +account.id != id);
    this.accountService.delete(id).subscribe(data => {});
  }

}
