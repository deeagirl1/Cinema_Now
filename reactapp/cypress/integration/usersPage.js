/* ==== Test Created with Cypress Studio ==== */
it('Admin login ', function() {
  /* ==== Generated with Cypress Studio ==== */
  cy.visit('http://localhost:3000/');
  cy.get('[data-testid="LoginIcon"] > path').click();
  cy.get('#formBasicUsername').clear();
  cy.get('#formBasicUsername').type('oanceaa');
  cy.get('#formBasicPassword').clear();
  cy.get('#formBasicPassword').type('123');
  cy.get('.btn').click();
  /* ==== End Cypress Studio ==== */
});
