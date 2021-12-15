beforeEach(() => {
    cy.login("mari", "123")
  })

  it('ViewComplaintsAdmin', function() {
    cy.visit('http://localhost:3000/complaints');
  });