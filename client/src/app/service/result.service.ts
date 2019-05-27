import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CandidateResult } from '../model/candidate-result';
import { CandidateRegion } from '../model/candidate-region';
import { CandidateTop } from '../model/candidate-top';
import { CandidateAvg } from '../model/candidate-avg';
import { CandidateCitizen } from '../model/candidate-citizen';
import { Citizen } from '../model/citizen';

@Injectable({
  providedIn: 'root'
})
export class ResultService {

  constructor(private http: HttpClient) { }
  baseUrl: string = 'http://localhost:8080/';
  
  getResultsByElectionId(electionId:number, minPercentege:number): Observable<CandidateResult[]>{
    return this.http.get<CandidateResult[]>(this.baseUrl+"elections/winners/"+electionId + '/' + minPercentege);
  }

  getWinnerResultsByElectionId(electionId:number): Observable<CandidateRegion[]>{
    return this.http.get<CandidateRegion[]>(this.baseUrl+"elections/regionAndItsWinner/"+electionId);
  }

  getTopResultsByElectionId(electionId:number, regionAmount:number, positionAmount:number): Observable<CandidateTop[]>{
    return this.http.get<CandidateTop[]>(this.baseUrl+"elections/topResults/"+electionId+regionAmount+positionAmount);
  }

  getAvgAgeResultsByElectionId(electionId:number): Observable<CandidateAvg[]>{
    return this.http.get<CandidateAvg[]>(this.baseUrl+"elections/averageAge/"+electionId);
  }

  getAvgAgeResultsByElectionIdVotedForWinners(electionId:number): Observable<CandidateCitizen[]>{
    return this.http.get<CandidateCitizen[]>(this.baseUrl+"elections/citizensAndCandidates/"+electionId);
  }

  getCitizensVotedInElectionById(electionId:number): Observable<Citizen[]>{
    return this.http.get<Citizen[]>(this.baseUrl+"citizens/vote/"+electionId);
  }
}

