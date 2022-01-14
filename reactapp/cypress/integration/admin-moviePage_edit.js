/* ==== Test Created with Cypress Studio ==== */
describe("Add movie", () => {
it('EditMovie', function() {
  /* ==== Generated with Cypress Studio ==== */
  cy.visit('http://localhost:3000/sign-in');
  cy.get('#username').clear();
  cy.get('#username').type('oanceaa');
  cy.get('#password').clear();
  cy.get('#password').type('123');
  cy.get('#submit').click();
  cy.get('.me-auto > .dropdown > #dropdown-basic').click();
  cy.get('#movies').click();
  cy.get('[aria-label="edit"] > .MuiSvgIcon-root').click(1);
  cy.get('#genre').select('2');
  cy.get('#format').select('1');
  cy.get('form').click();
  cy.get('#duration').clear();
  cy.get('#duration').type('312');
  cy.get('#projection').select(0);
  cy.get('#room').select(0);
  cy.get('#submit').click();
  /* ==== End Cypress Studio ==== */
})
});