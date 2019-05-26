import { Component, OnInit } from '@angular/core';
import { Election} from 'src/app/model/election'
import { ElectionService } from 'src/app/service/election.service';
import { Router } from '@angular/router';
import { ElectionDTO } from 'src/app/model/election-dto';

@Component({
  selector: 'app-list-of-elections-active',
  templateUrl: './list-of-elections-active.component.html',
  styleUrls: ['./list-of-elections-active.component.css']
})
export class ListOfElectionsActiveComponent implements OnInit {

  elections: ElectionDTO[];
  selectedElection: ElectionDTO = null;

  constructor(
    private electionService: ElectionService,
    private router: Router
    )
     { }

  ngOnInit() {
    this.electionService.findActive().subscribe(data =>
      {
        this.elections = data;
      });
  }
  vote(election: ElectionDTO): void {
    this.selectedElection = election;
    this.router.navigate(['elections/' + this.selectedElection.id + '/vote']);
  }

}
