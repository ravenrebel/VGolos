import { Account } from '../account';

export class SignupCitizenForm extends Account {
    firstName : string;
    lastName : string;
    fathersName : string;
    dateOfBirth : Date;
    idn : string;
    region : string;
}
