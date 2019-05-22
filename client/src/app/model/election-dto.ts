import { CandidateDTO } from './candidate-dto';
import { VoteDTO } from './vote-dto';

export class ElectionDTO {
    id : number;
    name : string;
    year : number;
    tour : number;
    beginningOfVoting : Date;
    endOfVoting : Date;
    candidates : CandidateDTO[];
    votes : VoteDTO[];
}
