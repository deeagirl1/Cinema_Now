describe("renders the room page", ()=> {
it("deletes room", ()=> {
  cy.visit("/")
  /* ==== Generated with Cypress Studio ==== */
  cy.get('#signIn').click();
  cy.get('#username').clear();
  cy.get('#username').type('oanceaa');
  cy.get('#password').clear();
  cy.get('#password').type('123');
  cy.get('#submit').click();
  cy.get('.me-auto > .dropdown > #dropdown-basic').click();
  cy.get('#rooms').click();

  /* ==== Generated with Cypress Studio ==== */
  cy.get('#deleteRoom > .MuiSvgIcon-root > path').click();
  /* ==== End Cypress Studio ==== */
})

})