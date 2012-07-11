//
//  ViewController.m
//  AOC1_Project2
//
//  Created by Joel Betterly on 7/11/12.
//  Copyright (c) 2012 Full Sail. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad
//Add all code here for buttons

//Section I [View] 
//Step 1 Change background color.
{
    self.view.backgroundColor = [UIColor brownColor];

//Section II [Book Information and UILabels]   
//Step 1 Create a UILabel and place it at the top. Center the text.
//Make sure to add variables to the ViewController.h file for each variable/button you make.
    
    titleOfBook = [[UILabel alloc] initWithFrame:CGRectMake(10, 10, 300, 40)];
    if (titleOfBook !=nil) {
        titleOfBook.text = @"The Stand";
        titleOfBook.textColor = [UIColor whiteColor];
        titleOfBook.backgroundColor = [UIColor blueColor];
        titleOfBook.textAlignment = UITextAlignmentCenter;
    }
    [self.view addSubview:titleOfBook];
    
//Step 2 Create another label that contains the text "Author:" with the text justified right.
//copy/paste from above and just change variable.  Change colors and lable size to match demo.png

    author = [[UILabel alloc] initWithFrame:CGRectMake(10, 70, 100, 25)];    
    if (author !=nil) {
        author.text = @"Author: ";
        author.textColor = [UIColor whiteColor];
        author.backgroundColor = [UIColor blueColor];
        author.textAlignment = UITextAlignmentRight;
    }
    [self.view addSubview:author];
    
//Step 3 Create a UILabel to the right of the author with text justified left.    
//Copy/Paste from above change coordinates and colors     

    authorName = [[UILabel alloc] initWithFrame:CGRectMake(115, 70, 200, 25)];    
    if (authorName !=nil) {
        authorName.text = @"Stephen King";
        authorName.textColor = [UIColor whiteColor];
        authorName.backgroundColor = [UIColor blueColor];
        authorName.textAlignment = UITextAlignmentLeft;
    }
    [self.view addSubview:authorName];

//Step 4 Create a uilabel on next line called "Published: " Text right justified.
//Copy/paste step two change variable and colors
    
    published = [[UILabel alloc] initWithFrame:CGRectMake(10, 103, 100, 25)];    
    if (published !=nil) {
        published.text = @"Published: ";
        published.textColor = [UIColor whiteColor];
        published.backgroundColor = [UIColor blueColor];
        published.textAlignment = UITextAlignmentRight;
    }
    [self.view addSubview:published];    
//Step 5 Create a label next to the published label and add the text of when the book was publisjed, left justify text.
//Copy/Paste, change variable and colors and coordinates just like above.

    publishedDate = [[UILabel alloc] initWithFrame:CGRectMake(115, 103, 200, 25)];    
    if (publishedDate !=nil) {
        publishedDate.text = @"September 1978";
        publishedDate.textColor = [UIColor whiteColor];
        publishedDate.backgroundColor = [UIColor blueColor];
        publishedDate.textAlignment = UITextAlignmentLeft;
    }
    [self.view addSubview:publishedDate]; 
    
//Step 6 Create a UILabel with the text "Summary".  Left justify text.
//You guessed it, copy and paste blah blah blah.
    
    summary = [[UILabel alloc] initWithFrame:CGRectMake(10, 130, 100, 25)];    
    if (summary !=nil) {
        summary.text = @"Summary";
        summary.textColor = [UIColor whiteColor];
        summary.backgroundColor = [UIColor blueColor];
        summary.textAlignment = UITextAlignmentLeft;
    }
    [self.view addSubview:summary]; 
    
//Step 7 Create another UILabel that contains a small summary of the books plot. Text is centered span multiple lines.
//Copy/paste blah, blah blah, make sure to add numberoflines = 9 (whatever you need) align text.
    
    plot = [[UILabel alloc] initWithFrame:CGRectMake(10, 155, 300, 200)];    
    if (plot !=nil) {
        plot.text = @"A devastating flu escapes from its containment in a military biowarfare lab, killing most of the population of the world. Those who remain, immune to the disease, receive dreams that lead them to align themselves either with the forces of good, or the forces of evil, prepare for the inevitable confrontation between the two sides.";
        
//King, S. (1978, September). synopsis. Retrieved from http://product.half.ebay.com/The-Stand-by-Stephen-King-1990-Hardcover/157749&tg=info        
        
        plot.textColor = [UIColor whiteColor];
        plot.backgroundColor = [UIColor blueColor];
        plot.textAlignment = UITextAlignmentCenter;
        plot.numberOfLines = 9;
    }
    [self.view addSubview:plot];     
    
//Section III [Labels and Arrays]
    
//Step 1 Create an NSArray, 5 items, Items to be NSStrings Add items to array.
    
    NSArray *bookItemsArray = [[NSArray alloc] initWithObjects:@"Walking Dude", @"Captain Trips", @"Trashcan Man ", @"Boulder Colorado", @"Kojack", nil];
    
//Step 2 Create a variable type NSMuatableString, alloc  loop through NSArray append to the string seperated by commas.
    
    NSMutableString *mutableString = [[NSMutableString alloc] init];
    for (int i=0; i<bookItemsArray.count; i++) 
    {NSString *stuff = [bookItemsArray objectAtIndex:i];
        if (bookItemsArray.count == i+1){
            
            [mutableString appendString:stuff];
            
        } else {
            
            [mutableString appendString:[[NSString alloc] initWithFormat:@"%@, ", stuff]];
        }
    }
    
//Step 3 Create a label with the "List Of Items" add to parent view, text left justified.
    
    itemsList = [[UILabel alloc] initWithFrame:CGRectMake(10, 360, 130, 25)];    
    if (itemsList !=nil) {
        itemsList.text = @"List of Items: ";
        itemsList.textColor = [UIColor whiteColor];
        itemsList.backgroundColor = [UIColor blueColor];
        itemsList.textAlignment = UITextAlignmentLeft;
    }
    [self.view addSubview:itemsList];   
    
//Step 4 create a label set the text nsmutablestring text. increse lines text is cenetered.
    
    arrayOutput = [[UILabel alloc] initWithFrame:CGRectMake(10, 385, 300, 100)];    
    if (arrayOutput !=nil) {
        arrayOutput.text = mutableString;
        arrayOutput.textColor = [UIColor whiteColor];
        arrayOutput.backgroundColor = [UIColor blueColor];
        arrayOutput.textAlignment = UITextAlignmentLeft;
        arrayOutput.numberOfLines = 9;
    }
    [self.view addSubview:arrayOutput];     
    
    
    
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
} //closing brace for background parent

//Leave the rest of the code from here down alone


- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    if ([[UIDevice currentDevice] userInterfaceIdiom] == UIUserInterfaceIdiomPhone) {
        return (interfaceOrientation != UIInterfaceOrientationPortraitUpsideDown);
    } else {
        return YES;
    }
}

@end
