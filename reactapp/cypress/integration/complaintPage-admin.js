beforeEach(() => {
    cy.login("oanceaa", "123")
  })

  it('ViewComplaintsAdmin', function() {
    cy.visit('http://localhost:3000/complaints');
  });