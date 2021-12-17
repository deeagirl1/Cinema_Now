describe("renders the registerion page", ()=> {
    it("registers user correctly", ()=> {
        cy.visit("/sign-up")

        /* ==== Generated with Cypress Studio ==== */
        cy.get(':nth-child(2) > div > .form-control').clear();
        cy.get(':nth-child(2) > div > .form-control').type('andreea');
        cy.get(':nth-child(4) > div > .form-control').clear();
        cy.get(':nth-child(4) > div > .form-control').type('Andreea');
        cy.get(':nth-child(6) > div > .form-control').clear();
        cy.get(':nth-child(6) > div > .form-control').type('Sindrilaru');
        cy.get(':nth-child(8) > div > .form-control').clear();
        cy.get(':nth-child(8) > div > .form-control').type('a.sindrilaru@gmail.com');
        cy.get(':nth-child(10) > div > .form-control').clear();
        cy.get(':nth-child(10) > div > .form-control').type('123456');
        cy.get('#submit').click();
        /* ==== End Cypress Studio ==== */
    })

})