import { Component, OnInit } from '@angular/core';
import { Election} from 'src/app/model/election'
import { ElectionService } from 'src/app/service/election.service';
import { Router } from '@angular/router';
import { ElectionDTO } from 'src/app/model/election-dto';


@Component({
  selector: 'app-home-page-list-of-elections',
  templateUrl: './home-page-list-of-elections.component.html',
  styleUrls: ['./home-page-list-of-elections.component.css']
})
export class HomePageListOfElectionsComponent implements OnInit {

  elections: ElectionDTO[];

  constructor(
    private electionService: ElectionService,
    private router: Router
 
   ) 
   {

  }

  ngOnInit() {
    this.electionService.findAll().subscribe(data =>
      {
        this.elections = data;
      });
  }

}
