describe('Sign Up Page test', function () {
    it('Checks default items', function () {
        cy.visit('http://localhost:3000/register')

        cy.contains('Username')
        cy.contains('Email')
        cy.contains('Password')
        cy.url()
            .should('includes', '/register')
    })
})