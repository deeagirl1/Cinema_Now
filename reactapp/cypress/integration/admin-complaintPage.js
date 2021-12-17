/* ==== Test Created with Cypress Studio ==== */
it('ViewComplaints', function() {
  /* ==== Generated with Cypress Studio ==== */
  cy.visit('http://localhost:3000/sign-in');
  /* ==== Generated with Cypress Studio ==== */
  cy.get('#username').clear();
  cy.get('#username').type('oanceaa');
  cy.get('#password').clear();
  cy.get('#password').type('123');
  cy.get('#submit').click();
  cy.get('#receivedComplaints').click();
  /* ==== End Cypress Studio ==== */
});