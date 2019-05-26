import { Component, OnInit } from '@angular/core';
import { Election} from 'src/app/model/election'
import { ElectionService } from 'src/app/service/election.service';
import { Router } from '@angular/router';
import { ElectionDTO } from 'src/app/model/election-dto';

@Component({
  selector: 'app-list-of-elections-completed',
  templateUrl: './list-of-elections-completed.component.html',
  styleUrls: ['./list-of-elections-completed.component.css']
})
export class ListOfElectionsCompletedComponent implements OnInit {

  elections: ElectionDTO[];

  constructor(
    private electionService: ElectionService,
    private router: Router
    )
     { }

  ngOnInit() {
    this.electionService.findFinished().subscribe(data =>
      {
        this.elections = data;
      });
  }

}
