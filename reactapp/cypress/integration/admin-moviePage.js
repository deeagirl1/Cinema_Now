describe("renders the home page", ()=> {
    it("add Room", ()=> {
      cy.visit("/sign-in")

      /* ==== Generated with Cypress Studio ==== */
      cy.get('#username').clear();
      cy.get('#username').type('oanceaa');
      cy.get('#password').clear();
      cy.get('#password').type('123');
      cy.get('#submit').click();
      cy.get('.me-auto > .dropdown > #dropdown-basic').click();
      cy.get('#rooms').click();
      cy.get('[data-testid="AddIcon"]').click();
      cy.get('#roomNumber').clear();
      cy.get('#roomNumber').type('213');
      cy.get('#capacity').clear();
      cy.get('#capacity').type('20');
      cy.get('#submit').click();
      /* ==== End Cypress Studio ==== */
    })

    it("add Projection", ()=> {
      cy.visit("/sign-in")

      /* ==== Generated with Cypress Studio ==== */
      cy.get('#username').clear();
      cy.get('#username').type('oanceaa');
      cy.get('#password').clear();
      cy.get('#password').type('123');
      cy.get('#submit').click();


      /* ==== End Cypress Studio ==== */
      /* ==== Generated with Cypress Studio ==== */
      cy.get('.me-auto > .dropdown > #dropdown-basic').click();
      cy.get('#projections').click();
      cy.get('[data-testid="AddIcon"]').click();
      cy.get('#projectionDate').clear();
      cy.get('#projectionDate').type('25/05/2021');
      cy.get('#projectionTime').clear();
      cy.get('#projectionTime').type('15:00');
      cy.get('#submit').click();
      /* ==== End Cypress Studio ==== */
    })

    it("add Movie", ()=> {
      cy.visit("/sign-in")

      /* ==== Generated with Cypress Studio ==== */
      cy.get('#username').clear();
      cy.get('#username').type('oanceaa');
      cy.get('#password').clear();
      cy.get('#password').type('123');
      cy.get('#submit').click();


      /* ==== Generated with Cypress Studio ==== */
      cy.get('.me-auto > .dropdown > #dropdown-basic').click();
      cy.get('#movies').click();
      cy.get('[data-testid="AddIcon"]').click();
      cy.get('#title').clear();
      cy.get('#title').type('test');
      cy.get('#genre').select('ACTION');
      cy.get('#releaseDate').clear();
      cy.get('#releaseDate').type('test');
      cy.get('#duration').clear();
      cy.get('#duration').type('213');
      cy.get('#description').clear();
      cy.get('#description').type('test');
      cy.get('#format').select('_3D');
      cy.get('#director').clear();
      cy.get('#director').type('test');
      cy.get('#room').select(1);
      cy.get('#projection').select(0);
      cy.get('#submit').click();
      /* ==== End Cypress Studio ==== */
    })
  
  })