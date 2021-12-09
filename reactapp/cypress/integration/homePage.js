describe("renders the home page", ()=> {
    it("renders correctly", ()=> {
        cy.visit("/")
        /* ==== Generated with Cypress Studio ==== */
        cy.get('.next').click();
        cy.get('.next').click();
        cy.get('.next').click();
        cy.get('.next').click();
        /* ==== End Cypress Studio ==== */
    })

    /* ==== Test Created with Cypress Studio ==== */
    it('Admin Sign In', function() {
        /* ==== Generated with Cypress Studio ==== */
        cy.visit('/sign-in');
        cy.get('#formBasicUsername').clear();
        cy.get('#formBasicUsername').type('oanceaa');
        cy.get('#formBasicPassword').clear();
        cy.get('#formBasicPassword').type('123');
        cy.get('.btn').click();
        /* ==== End Cypress Studio ==== */
    });

       /* ==== Test Created with Cypress Studio ==== */
       it('User Sign In', function() {
           /* ==== Generated with Cypress Studio ==== */
           cy.visit('/sign-in');
           cy.get('#formBasicUsername').clear();
           cy.get('#formBasicUsername').type('mari');
           cy.get('#formBasicPassword').clear();
           cy.get('#formBasicPassword').type('123');
           cy.get('.btn').click();
           /* ==== End Cypress Studio ==== */
           /* ==== Generated with Cypress Studio ==== */
           /* ==== End Cypress Studio ==== */
       });
})