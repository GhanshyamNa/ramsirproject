
import { Applicant } from "./applicant";
import { LoanDetails } from "./loan-details";
import { Sanction } from "./sanction";

export class LoanApprovedList {
    
    loanAid:number;   
    loanDetails: LoanDetails;
    sanction: Sanction;
    applicant: Applicant
}
