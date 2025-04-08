[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/E_3pSpcM)
[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/gjhP1jyU)
![Flier for an EChALE STEM Loteria night fundraiser](https://i.imgur.com/nnPOLo3.png)

# **Lab #8 - Loteria + Event Handling**

EChALE STEM (**E**mpowering **Ch**icanx **A**nd **L**atinx **E**xploring **STEM**) Club hosts a fundraising event every
semester where attendees pay for a playing card (the sheet with multiple Loteria cards to fill). Through their personal
identity exploration, as well as events on campus like Professor Alicia Lopez's workshop on Chicanx/Latinx identities,
they've reflected and decided to create a new version of Loteria to address some of the issues in the original they saw.
Instead of the traditional cards, they've replaced them all with STEM professions and STEM related things in Spanish to
create their own EChALE STEM Loteria!

Through your understanding of the Loteria game mechanics and consultation with EChALE members you've agreed on the
following wireframe for the GUI:
![Wireframe showing GUI components](https://imgur.com/HQd6DPS.png)

Your project partner started you off, setting up some of the data (LoteriaCard model class and gathering the
images/information for a few cards) as well as the template for a basic GUI project.

Your part of the project is to be the finisher, complete the GUI program so that it contains all of the components from
the wireframe above in the layout shown. This will require you to look up some Java Documentation and examples to get
them working right, lean on the last lab and the Oracle documentation to get it looking like the *Sample Working
Screenshot* below!

## **List of Requirements/Steps:**

0. Familiarize yourself with the code
    - `LoteriaCard` is given to you, no edits will be necessary in this file
    - Remind yourself about the requirements for JavaFX applications, their sturcture, and how to get a GUI working
1. Get the look down
    - Focus first on laying out all the GUI components, not necessarily looking exactly the same as the working
      screenshot but just the components themselves. Get basic things like the size and locations working correctly so
      that it resembles the wireframe
        - Specifically, the `VBox` layout containing the `titleLabel`, `cardImageView`, `messageLabel`, and
          `drawCardButton`. You can add the `gameProgressBar` now but it's for the Hacker Challenge, so you can wait
          till the end
    - Next, upgrade their look so it resembles what the working screenshot looks like. Fix alignment, colors, font
      sizes, etc. so its as close as possible without all the interaction
    - **TIP**: window size should be 350x500. Use `LoteriaCard`'s `getImage` method to get the `Image` object of the
      Loteria card to display in
      the [ImageView](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html)
2. Now focus on the event handling!
    - Specifically, this lab requires you use ***anonymous classes*** for the event handling of the button click. In
      there you will:
        - change the card in the `ImageView` to a random Loteria card (we'll upgrade this later, in the Hacker
          Challenge!)

## **Hacker Challenge**

The steps above only pik a card randomly, over and over again, which meanns it can repeat cards! Upgrade the code so
that it actually only shows each card once, still chosen at random, and ends the game:

- NOTE: You should not be using any data structures we haven't covered yet in CS111/CS112, that means stick to arrays 😄
- Use the [ProgressBar](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ProgressBar.html) to show how
  many cardrs have been drawn. Note that the progress is set between 0.0 and 1.0, so calculate it using the array size
  to make your program flexible for future card additions!
- Also, change the `gameProgressBar` to red when thhe game is over
- Change the `messageLabel` to the game over message:
  `"GAME OVER. No more cards! Exit and run program again to reset ^_^"`
- Change the `cardImageView` to the EChALE logo
- Disable the `drawCardButton` to prevent the user from drawing more cards

## **Sample Working Screenshots:**

*Note that your output may differ from the examples shown below, as long as it fulfills the requirements above, and the
GUI is clean, you have creative liberty on how you provide feedback to the user.*

![Demo of what a fully working GUI could look like for this project](https://i.imgur.com/0XEzTQO.gif)
Note the little details that improve the UI/UX, like disabling the "Draw Random Card" button when the 4 cards are drawn,
as well as changing the `ProgressBar` color to red. There aren't requirements, but little extras added that you could
try or make your own! Have fun with it, think of what would make it easier for the user and would help them with the
game!

## **Acknowledgements:**

![Picture of Rosey](https://i.imgur.com/9Je8qpy.jpg)
[![LinkedIn Logo](https://i.imgur.com/v8fiNiM.png)](https://www.linkedin.com/in/rosey-a-gutierrez/)

Rosey Gutierrez (*TA/intern for GOALS in CS project, EChALE STEM Co-Outreach Chair 2020, WiCS President 2021*)

Project inspired by (most of the code is) Rosey's final project from CS112