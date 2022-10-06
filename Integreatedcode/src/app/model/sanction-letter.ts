import { LoanApprovedList } from 'app/model/loan-approved-list';
export class SanctionLetter {
    sanctionId: number;
    lal: LoanApprovedList;
    sanctionDate: string;
    status: string;
    monthlyEMIAmount:number;
    principalAmount:number;
    totalInterest: number;
    totalAmount:number;
}
