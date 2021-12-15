/* ==== Test Created with Cypress Studio ==== */

beforeEach(() => {
  cy.login("mari", "123")
})

it('SendComplaintUser', function() {
  /* ==== Generated with Cypress Studio ==== */
  cy.visit('http://localhost:3000/complaints');
  /* ==== End Cypress Studio ==== */

  /* ==== Generated with Cypress Studio ==== */
  cy.get(':nth-child(2) > .form-control').clear();
  cy.get(':nth-child(2) > .form-control').type('test');
  cy.get('#formBasicPassword').click();
  cy.get('#formBasicPassword').type("test");
  cy.get('form > .btn').click();
  /* ==== End Cypress Studio ==== */
});

