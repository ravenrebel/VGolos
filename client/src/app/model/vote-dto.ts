import { Citizen } from './citizen';
import { CandidateDTO } from './candidate-dto';

export class VoteDTO {
    id : number;
    candidate : CandidateDTO;
    citizen : Citizen;
    electionId : number;
    
}
