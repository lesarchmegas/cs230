CS 230 Portfolio Submission – Module Eight Journal

This repository contains my completed work from CS 230: Operating Platforms, including the Software Design Document for The Gaming Room. This project was developed as a professional design document for a client and demonstrates my ability to design software systems, document requirements, and effectively communicate technical solutions.

This submission is part of my Computer Science portfolio, where I will continue to add artifacts from future courses. The portfolio serves both as a way to track my learning and as a showcase of my best work for potential employers.

The Gaming Room was the client, and they wanted to expand their existing game “Draw It or Lose It” into a web-based application. Their requirements included ensuring unique game and team names, supporting multiple concurrent sessions, and making the system scalable across multiple platforms. The solution needed to allow only one active instance of the game service in memory while supporting multiple clients simultaneously.

I did a strong job of breaking down the system architecture and design constraints in clear, structured sections. I also created a domain model that captured the relationships between the entities (Game, Team, Player) effectively, which made the requirements easier to understand for both the client and developers.

The design document acted as a blueprint, helping me map out the structure before touching the code. Having the requirements, design patterns, and architecture outlined first gave me a roadmap and prevented wasted time rewriting code due to unclear requirements.

If I could revise one part of my work, I would expand on the evaluation and recommendations section to include more detail on alternative architectures. While I covered the main design patterns, I could have provided deeper comparisons of different approaches to scalability and platform independence.

I interpreted the user’s needs by translating their high-level requirements, such as scalability and unique game sessions, into concrete design constraints like enforcing unique names through data structures and using a singleton pattern for the game service. Considering user needs is critical because software is only successful if it solves the user’s actual problems and delivers a positive experience. Ignoring user needs often results in software that is technically functional but fails in real-world usage.

I approached design by first analyzing requirements and then mapping them into an architecture that fit both the technical constraints and the client’s goals. I used UML diagrams, design patterns, and modular documentation to ensure clarity. In the future, I would use a similar structured approach but also incorporate agile feedback loops, gathering input from users and stakeholders earlier in the design phase to refine the solution before coding begins.

This repository contains the Software Design Document for The Gaming Room, coursework from CS 230, and this README file with my journal reflection.
