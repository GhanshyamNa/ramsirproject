export class Menu {
    public static menu: Array<any> = [
      {
        admin: [
          {path: "adminbash", title: "Dashbord", icon: "pe-7s-graph", class: "" },
          {path: "city", title: "Create Student", icon: "pe-7s-graph", class: "" }
      ],
      account: [
        {path: "loanlist", title: "Sanction List", icon: "pe-7s-graph", class: "" },
       // {path: "bank", title: "Loan Disburse", icon: "pe-7s-graph", class: "" },
        {path: "ledgerform", title: "Ledger Creation", icon: "pe-7s-graph", class: "" },
        {path: "ledgerview", title: "Ledger Data list", icon: "pe-7s-graph", class: "" }
  
    ],
  
    operation:[
      {path: "oedash", title: "DASHBORD", icon: "pe-7s-graph", class: "" },
      {path: "oeenq", title: "VIEW ENQUIERY", icon: "pe-7s-graph", class: "" },
      {path: "oecustomer", title: "VIEW CUSTOMER", icon: "pe-7s-graph", class: "" },
      {path: "cibil", title: "CIBILSCORE", icon: "pe-7s-graph", class: "" }
    ],
    relation:[
        {path: "oeenquiry", title: "ENQUERY", icon: "pe-7s-graph", class: "" },
        {path: "oecustomer", title: "REGISTER CUSTOMER", icon: "pe-7s-graph", class: "" },
        {path: "oedocument", title: "UPLOAD DOCUMENT", icon: "pe-7s-graph", class: "" }

      ],
      cr:[{path: "credit", title: "Loan Verified List", icon: "pe-7s-graph", class: "" },
       
        { path: "Letter", title: "Sanction List", icon: "pe-7s-graph", class: "" },
           {path: "mail", title: "Mail Sender", icon: "pe-7s-graph", class: "" },
      ],
      ab:[{path: "abcdash", title: "DASHBOARD", icon: "pe-7s-graph", class: "" }]
      }
    ];
  }
  