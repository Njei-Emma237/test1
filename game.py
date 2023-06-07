import random

# Initialize the game
score = 0
lives = 3

# Create the game loop
while lives > 0:
    # Generate a random number
    number = random.randint(1, 10)

    # Get the user's guess
    guess = int(input("Guess a number between 1 and 10: "))

    # Check if the user guessed correctly
    if guess == number:
        print("Correct! Your score is now", score + 1)
        score += 1
    else:
        print("Incorrect! You lose a life.")
        lives -= 1

# Display the final score
print("Game over! Your final score is", score)
