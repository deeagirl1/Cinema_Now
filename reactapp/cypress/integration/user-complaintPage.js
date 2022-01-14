
describe("renders the complaint page for user", ()=> {

  it('SendComplaintUser', function() {
  cy.login("andreea","123456");
  cy.visit('/complaints');
  cy.get('#title').type('test');
  cy.get('#container').type('test');
  cy.get('#submit').click();

})
})

