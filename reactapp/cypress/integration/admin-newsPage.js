
describe("renders the news page", ()=> {
    it("adds new post correctly", ()=> {
        cy.visit("/sign-in")


        /* ==== Generated with Cypress Studio ==== */
        cy.get('#username').clear();
        cy.get('#username').type('oanceaa');
        cy.get('#password').clear();
        cy.get('#password').type('123');
        cy.get('#submit').click();
        cy.get('[data-testid="AddIcon"] > path').click();
        cy.get('#title').clear();
        cy.get('#title').type('test');
        cy.get('#description').type('test');
        cy.get('#submit').click();
        /* ==== End Cypress Studio ==== */
    })

    it("deletes new post correctly", ()=> {
        cy.visit("/sign-in")


        /* ==== Generated with Cypress Studio ==== */
        cy.get('#username').clear();
        cy.get('#username').type('oanceaa');
        cy.get('#password').clear();
        cy.get('#password').type('123');
        cy.get('#submit').click();
        /* ==== End Cypress Studio ==== */
    })

})
