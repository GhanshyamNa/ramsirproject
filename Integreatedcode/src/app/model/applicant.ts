import { Cibil } from './cibil';
import { LoanDetails } from './loan-details';
import { PermanentAddress } from './permanent-address';
import { CurrentAddress } from './current-address';
import { Customer } from './customer';
import { PropertyDetails } from './property-details';
import { Document } from './document';
import { CustomerBankDetails } from './customer-bank-details';
export class Applicant {
   applicationId: string;
   education: string;
    nationality: string;
    profession: string;   
    customer: Customer;
    caddr: CurrentAddress;
    paddr: PermanentAddress;	
    loanDetails: LoanDetails;	
    propertydetails: PropertyDetails;   
    bankdetails: CustomerBankDetails;
     verificationResult: string;
    
   
}
