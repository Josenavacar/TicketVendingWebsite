describe('Fan load test', function () {
    it('Finds default fan', function () {
        cy.visit('http://localhost:3000/fans')

        cy.contains('JohnDoe')
        cy.contains('jdoe@gmail.com')
        cy.url()
            .should('includes', '/fans')
    })
})