describe("renders the home page", ()=> {
  it("deletes movie", ()=> {
    cy.visit("/")
    /* ==== Generated with Cypress Studio ==== */
    cy.get('#signIn').click();
    cy.get('#username').clear();
    cy.get('#username').type('oanceaa');
    cy.get('#password').clear();
    cy.get('#password').type('123');
    cy.get('#submit').click();
    cy.get('.me-auto > .dropdown > #dropdown-basic').click();
    cy.get('#movies').click();
    cy.get('[aria-label="delete"] > .MuiSvgIcon-root > path').click();
    /* ==== End Cypress Studio ==== */
  })

 

})