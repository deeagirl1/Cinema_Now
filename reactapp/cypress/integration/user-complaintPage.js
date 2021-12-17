
describe("renders the complaint page for user", ()=> {

  beforeEach(() => {
    cy.login("andreea","123456");
    cy.saveLocalStorage();
  });
  
  beforeEach(() => {
    cy.restoreLocalStorage();
  });
 
it('SendComplaintUser', function() {
  cy.visit("/sign-in")

  /* ==== Generated with Cypress Studio ==== */
  cy.contains('Complaints').click();
  cy.get('#title').type('test');
  cy.get('#container').type('test');
  cy.get('#submit').click();
  /* ==== End Cypress Studio ==== */
})
})

